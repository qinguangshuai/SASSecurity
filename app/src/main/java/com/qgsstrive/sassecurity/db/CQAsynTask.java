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

public class CQAsynTask extends AsyncTask<String, Void, List<CQUser>> {
	private static final String TAG = "GetWordInfoAsynTask";
	private static final String EXCEPTION = "exception";
	private Context mContext = null;
	private AssetsDatabaseManager dbManager = null;

	public CQAsynTask(Context context) {
		this.mContext = context;
		// 初始化，只需要调用一次
		AssetsDatabaseManager.initManager(context);
	}

	@Override
	protected void onPostExecute(List<CQUser> vocabularyInfos) {
		super.onPostExecute(vocabularyInfos);
		if (ListUtils.isEmpty(vocabularyInfos)){
			Log.d("zsj_getwordinfo","vocabularyInfos is null");
		}else {
			Log.d("zsj_getwordinfo","vocabularyInfos :" + vocabularyInfos.toString());
		}
	}

	@Override
	protected List<CQUser> doInBackground(String... params) {
		// 获取管理对象，因为数据库需要通过管理对象才能够获取
		dbManager = AssetsDatabaseManager.getManager();
		// 通过管理对象获取数据库
		SQLiteDatabase db = dbManager.getDatabase("SASSystem.db");
		List<CQUser> wordList = getWordInfo(db);
		return wordList;
	}

	public List<CQUser> getWordInfo(SQLiteDatabase db) {
		List<CQUser> wordList = new ArrayList<CQUser>();
		/*if (db == null || TextUtils.isEmpty(bookNameStr)) {
			return wordList;
		}*/

		CQUser info = null;
		Cursor cursor = null;
		try {
			cursor = db.rawQuery("select * from chongqing", new String[0]);
			if (cursor != null && cursor.moveToFirst()) {
				do {
					int id = cursor.getColumnIndex("id");
					Float startX = cursor.getFloat(cursor.getColumnIndex("startX"));
					Float startY = cursor.getFloat(cursor.getColumnIndex("startY"));
					Float stopX = cursor.getFloat(cursor.getColumnIndex("stopX"));
					Float stopY = cursor.getFloat(cursor.getColumnIndex("stopY"));

					info = new CQUser(id,startX,startY,stopX,stopY);
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
