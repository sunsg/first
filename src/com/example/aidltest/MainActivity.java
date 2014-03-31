package com.example.aidltest;

import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	private ISunsg sunsg;
	 private ServiceConnection connect;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binderService(new Runnable() {
			
			@Override
			public void run() {
				try {
					sunsg.start("开始1");
					sunsg.stop("结束1");
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void onClickMe(View v){
    	
    }
    
    private void binderService(final Runnable run){
    	Intent intent = new Intent(TestService.ACTION);
    	connect = new ServiceConnection() {
    		
    		@Override
    		public void onServiceDisconnected(ComponentName name) {
    			sunsg = null;
    		}
    		
    		@Override
    		public void onServiceConnected(ComponentName name, IBinder service) {
    			sunsg = ISunsg.Stub.asInterface(service);
    			if(run != null) run.run();
    		}
    	};
    	bindService(intent, connect, Context.BIND_AUTO_CREATE);
    }
    
   
}
