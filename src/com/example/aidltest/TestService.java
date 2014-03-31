package com.example.aidltest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;

public class TestService extends Service{
	public static final String ACTION = "com.example.aidltest.TestService";
	

	@Override
	public IBinder onBind(Intent intent) {
		return binder;
	}
	
	private ISunsg.Stub binder = new ISunsg.Stub() {
		
		@Override
		public String stop(String params) throws RemoteException {
			Log.i("test", "test ISusng stop params = "+params);
			Toast.makeText(getApplicationContext(), "test ISusng stop params = "+params, 1).show();
			return null;
		}
		
		@Override
		public String start(String params) throws RemoteException {
			Log.i("test", "test ISusng start params = "+params);
			Toast.makeText(getApplicationContext(), "test ISusng start params = "+params, 1).show();
			return null;
		}
		
		@Override
		public void cancle() throws RemoteException {
			Log.i("test", "test ISusng cancle ");
			Toast.makeText(getApplicationContext(), "test ISusng cancle ", 1).show();
		}
	};

}
