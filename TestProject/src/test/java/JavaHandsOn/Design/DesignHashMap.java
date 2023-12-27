package JavaHandsOn.Design;

import JavaHandsOn.PersonSerializableTest;

public class DesignHashMap {
    private Object lockObject = new Object();
      private  void sample(){
        synchronized (lockObject){
            //criticla section of the code !!
        }
      }
}
