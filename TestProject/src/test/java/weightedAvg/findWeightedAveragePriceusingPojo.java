package weightedAvg;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 *
 * [
 *   {"orderId": "O1001", "symbol": "INFY", "price": 1500.50, "quantity": 10, "timestamp": 1693500300},
 *   {"orderId": "O1002", "symbol": "TCS",  "price": 3500.00, "quantity": 20, "timestamp": 1693500310},
 *   {"orderId": "O1001", "symbol": "INFY", "price": 1500.50, "quantity": 10, "timestamp": 1693500300},
 *   {"orderId": "O1003", "symbol": "INFY", "price": -1501.00, "quantity": 5,  "timestamp": 1693500320}
 * ]

 *
 *
 * this is json and You are automating end-to-end trade validation for a trading application:
 * Trades come in as a stream (simulated via an array of JSON events).
 * Some trades are duplicates (same orderId & timestamp) or invalid (negative quantity or price).
 * You need to detect and handle duplicates & invalid trades while also calculating VWAP for valid trades.


 * Task
 *
 * Input: Array of trades:
 * orderId (string)
 * symbol (string)
 * price (float)
 * quantity (int)
 * timestamp (epoch seconds)
 * Processing Requirements:
 * Remove duplicate trades (same orderId & timestamp).
 * Reject trades with quantity <= 0 or price <= 0.
 * Compute VWAP (Volume Weighted Average Price) per symbol after cleaning data.
 * Sort symbols alphabetically before printing.
 * Output:
 * List of rejected trades with reasons.
 * VWAP for each valid symbol in the format:

 * Symbol: VWAP
 *
 * sample input:  [
 *   {"orderId": "O1001", "symbol": "INFY", "price": 1500.50, "quantity": 10, "timestamp": 1693500300},
 *   {"orderId": "O1002", "symbol": "TCS",  "price": 3500.00, "quantity": 20, "timestamp": 1693500310},
 *   {"orderId": "O1001", "symbol": "INFY", "price": 1500.50, "quantity": 10, "timestamp": 1693500300},
 *   {"orderId": "O1003", "symbol": "INFY", "price": -1501.00, "quantity": 5,  "timestamp": 1693500320}
 * ]
 *
 * expected output:  Rejected Trades:
 * [{'orderId': 'O1001', 'symbol': 'INFY', 'reason': 'Duplicate'},
 * {'orderId': 'O1003', 'symbol': 'INFY', 'reason': 'Invalid price/quantity'}]

 * VWAP:
 * INFY -> 1500.50
 * TCS  -> 3500.00
 *
 *
 */
public class findWeightedAveragePriceusingPojo {
    public static void main(String[] args) throws IOException {

        String jsonData= Files.readString(Paths.get(System.getProperty("user.dir")+"/src/test/java/resources/Trades.json"));

//                + "/src/test/resources/trades.json"));
        Gson gson = new Gson();
        List<Trade> trades=gson.fromJson(jsonData,new TypeToken<List<Trade>>(){}.getType());
//        ObjectMapper mapper = new ObjectMapper();
//        List<Trade> trades= mapper.readValue(jsonData, new TypeReference<>() {});

        Set<TradeKey> seen = new HashSet<>();
        List<RejectedTrade> rejected = new ArrayList<>();
        Map<String, Double> totalPxQty = new HashMap<>();
        Map<String, Integer> totalQty = new HashMap<>();



        for (Trade trade : trades) {
            TradeKey key = new TradeKey(trade.getOrderId(), trade.getTimestamp());

            if (seen.contains(key)) {
                rejected.add(new RejectedTrade(trade.getOrderId(), trade.getSymbol(), "Duplicate trade detected"));
            }
            seen.add(key); // if will not matter if you add again.
            if(trade.getPrice()<=0 || trade.getQuantity()<=0) {
                rejected.add(new RejectedTrade(trade.getOrderId(), trade.getSymbol(), "Invalid price/quantity " + trade.getPrice()));
            }
            else {
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
          for (String symbol : sortedTrades ){
              double vwap=totalPxQty.get(symbol)/ totalQty.get(symbol);
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

}
