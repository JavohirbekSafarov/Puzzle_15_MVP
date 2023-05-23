package com.javohirbekcoder.puzzle15mvp.screens.records

import android.content.Context
import com.javohirbekcoder.puzzle15mvp.database.HighscoreDatabase
import com.javohirbekcoder.puzzle15mvp.database.HighscoreEntity


/*
Created by Javohirbek on 23.05.2023 at 11:50
*/
class RecordsRepository(private val context: Context) : RecordsContract.Repository {

    private val database: HighscoreDatabase = HighscoreDatabase(context)
    private val list: MutableList<HighscoreEntity>? = null
    override fun getTopScores(): List<HighscoreEntity> {
        list?.addAll(
            database.getHighScores()
        )
        return list?.toList() ?: emptyList()
    }
}