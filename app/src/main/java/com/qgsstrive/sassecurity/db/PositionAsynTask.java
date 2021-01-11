package com.qgsstrive.sassecurity.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.AsyncTask;
import android.util.Log;

import com.qgsstrive.sassecurity.util.AssetsDatabaseManager;
import com.qgsstrive.sassecurity.util.ListUtils;

import java.util.ArrayList;
import java.util.List;

public class PositionAsynTask extends AsyncTask<String, Void, List<PositionMap>> {
	private static final String TAG = "GetWordInfoAsynTask";
	private static final String EXCEPTION = "exception";
	private Context mContext = null;
	private AssetsDatabaseManager dbManager = null;

	public PositionAsynTask(Context context) {
		this.mContext = context;
		// 初始化，只需要调用一次
		AssetsDatabaseManager.initManager(context);
	}

	@Override
	protected void onPostExecute(List<PositionMap> vocabularyInfos) {
		super.onPostExecute(vocabularyInfos);
		if (ListUtils.isEmpty(vocabularyInfos)){
			Log.d("zsj_getwordinfo","vocabularyInfos is null");
		}else {
			Log.d("zsj_getwordinfo","vocabularyInfos :" + vocabularyInfos.toString());
		}
	}

	@Override
	protected List<PositionMap> doInBackground(String... params) {
		// 获取管理对象，因为数据库需要通过管理对象才能够获取
		dbManager = AssetsDatabaseManager.getManager();
		// 通过管理对象获取数据库
		SQLiteDatabase db = dbManager.getDatabase("SASSystem.db");
		List<PositionMap> wordList = getWordInfo(db);
		return wordList;
	}

	public List<PositionMap> getWordInfo(SQLiteDatabase db) {
		List<PositionMap> wordList = new ArrayList<PositionMap>();
		/*if (db == null || TextUtils.isEmpty(bookNameStr)) {
			return wordList;
		}*/

		PositionMap info = null;
		Cursor cursor = null;
		try {
			cursor = db.rawQuery("select * from chongqingtext", new String[0]);
			if (cursor != null && cursor.moveToFirst()) {
				do {
					int id = cursor.getColumnIndex("id");
					String name = cursor.getString(cursor.getColumnIndex("name"));
					int startX1 = cursor.getColumnIndex("startX");
					int startY1 = cursor.getColumnIndex("startY");
					float aFloat = cursor.getFloat(startX1);
					float aFloat1 = cursor.getFloat(startY1);
//					String startX = cursor.getString(cursor.getColumnIndex("startX"));
//					String startY = cursor.getString(cursor.getColumnIndex("startY"));
//					String endX = cursor.getString(cursor.getColumnIndex("endX"));
//					String endY = cursor.getString(cursor.getColumnIndex("endY"));

					info = new PositionMap(id,name,aFloat,aFloat1);
					if (info != null) {
						wordList.add(info);
					}
				} while (cursor.moveToNext());
			}

		} catch (SQLiteException e) {
			Log.e(TAG, EXCEPTION, e);
		} catch (Exception e) {
			Log.e(TAG, EXCEPTION, e);
		} finally {
			if (cursor != null) {
				cursor.close();
				cursor = null;
			}
			if (db != null) {
				//db.close();
			}
		}

		return wordList;
	}

}
