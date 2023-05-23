package com.javohirbekcoder.puzzle15mvp.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


/*
Created by Javohirbek on 20.05.2023 at 13:39
*/
class HighscoreDatabase(context: Context): SQLiteOpenHelper(
    context,DatabaseConfig.DB_NAME,null, DatabaseConfig.DB_VERSION
) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = "CREATE TABLE ${DatabaseConfig.TABLE_NAME}(${DatabaseConfig.ID} INTEGER PRIMARY KEY AUTOINCREMENT, ${DatabaseConfig.MOVES} INTEGER);"
        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS ${DatabaseConfig.TABLE_NAME}")
    }

    fun insert(highscoreEntity: HighscoreEntity){
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(DatabaseConfig.ID, highscoreEntity.id)
        contentValues.put(DatabaseConfig.MOVES, highscoreEntity.moves)
        db.insert(DatabaseConfig.TABLE_NAME, null, contentValues)
        db.close()
    }

    fun getHighScores(): List<HighscoreEntity> {
        val list: MutableList<HighscoreEntity> = ArrayList()
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM ${DatabaseConfig.TABLE_NAME} order by ${DatabaseConfig.MOVES} ASC Limit 5", null)
        if (cursor.moveToFirst()) {
            do {
                val id= cursor.getInt(0)
                val moves = cursor.getInt(1)
                val highscore = HighscoreEntity(id, moves)
                list.add(highscore)
            }while (cursor.moveToNext())
        }
        db.close()
        return list
    }

    fun clearAllRecords(){
        val db = this.writableDatabase
        db.execSQL("delete from ${DatabaseConfig.TABLE_NAME}")
        db.close()
    }

}