package weightedAvg;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

// please see othe classes here only change is we are using pojo and starts with {} not with []..

public class findWeightedAveragePriceusingPojoUsingObjectFormat {
    public static void main(String[] args) throws IOException {

        String jsonData = Files.readString(Paths.get(System.getProperty("user.dir") + "/src/test/java/resources/TradeObject.json"));

//                + "/src/test/resources/trades.json"));





        // ******************  for Gson mapper ******************

        //todo: only below line is changed from previous code rest is same.
//        Gson gson = new Gson();
//        TradeWrapper wrapper = gson.fromJson(jsonData, TradeWrapper.class);
//        List<Trade> trades = wrapper.getTrades();





     // ****************** for jakson mapper ******************

        ObjectMapper mapper = new ObjectMapper();
        TradeWrapper wrapper= mapper.readValue(jsonData,TradeWrapper.class);
        List<Trade> trades = wrapper.getTrades();






        Set<TradeKey> seen = new HashSet<>();
        List<RejectedTrade> rejected = new ArrayList<>();
        Map<String, Double> totalPxQty = new HashMap<>();
        Map<String, Integer> totalQty = new HashMap<>();


        for (Trade trade : trades) {
            TradeKey key = new TradeKey(trade.getOrderId(), trade.getTimestamp());

            if (seen.contains(key)) {
                rejected.add(new RejectedTrade(trade.getOrderId(), trade.getSymbol(), "Duplicate trade detected"));
            }
            seen.add(key); // it  will not matter if you add again.
            if (trade.getPrice() <= 0 || trade.getQuantity() <= 0) {
                rejected.add(new RejectedTrade(trade.getOrderId(), trade.getSymbol(), "Invalid price/quantity " + trade.getPrice()));
            } else {
                totalPxQty.merge(trade.getSymbol(), trade.getPrice() * trade.getQuantity(), Double::sum);
                totalQty.merge(trade.getSymbol(), trade.getQuantity(), Integer::sum);
            }

        }

        // Output
        System.out.println("Rejected Trades:");
        for (RejectedTrade rt : rejected) {
            System.out.println(rt);
        }

        TreeSet<String> sortedTrades = new TreeSet<>(totalPxQty.keySet()); // Sort symbols alphabetically
        System.out.println("\nVWAP:");
        for (String symbol : sortedTrades) {
            double vwap = totalPxQty.get(symbol) / totalQty.get(symbol);
            System.out.println("Symbol: " + symbol + ", VWAP: " + vwap);

        }
    }

    static class TradeKey {
        String orderId;
        long timestamp;

        TradeKey(String orderId, long timestamp) {
            this.orderId = orderId;
            this.timestamp = timestamp;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof TradeKey)) return false;
            TradeKey tradeKey = (TradeKey) o;
            return timestamp == tradeKey.timestamp && orderId.equals(tradeKey.orderId);
        }

        @Override
        public int hashCode() {
            return 31 * orderId.hashCode() + Long.hashCode(timestamp);
        }
    }

    static class RejectedTrade {
        String orderId;
        String symbol;
        String reason;

        RejectedTrade(String orderId, String symbol, String reason) {
            this.orderId = orderId;
            this.symbol = symbol;
            this.reason = reason;
        }

        @Override
        public String toString() {
            return "{'orderId': '" + orderId + "', 'symbol': '" + symbol + "', 'reason': '" + reason + "'}";
        }
    }


    @Data
    public static class Trade {
        private String orderId;
        private String symbol;
        private double price;
        private int quantity;
        private long timestamp;
    }

    @Data
    static class TradeWrapper {
        private List<Trade> trades;

    }
}
