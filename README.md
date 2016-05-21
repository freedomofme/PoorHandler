# PoorHandler
### update
1. V1.0 the easist handler

### function
1. main thread send message to subthread

 example:
 		
 	* MainThread:	
 	
 			poorHandler.sendMesage(2);
 	
 	* SubThread:

	 		class TestThread extends Thread {
        	public void run() {
            
           	Looper.prepare();
            poorHandler = new PoorHandler() {
                public void handleMessage(Message message) {
                    if (message.what == 1) {
                   
                    } else
                      
                }
            };
            Looper.loop();
        	}
    		}
 	
