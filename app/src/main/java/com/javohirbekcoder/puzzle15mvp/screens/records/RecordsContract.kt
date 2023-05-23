package com.javohirbekcoder.puzzle15mvp.screens.records

import com.javohirbekcoder.puzzle15mvp.database.HighscoreEntity


/*
Created by Javohirbek on 23.05.2023 at 11:47
*/
interface RecordsContract {
    interface Presenter {
        fun retrieveData()
        fun getRecords()
    }

    interface View {
        fun setHighScore(list: List<HighscoreEntity>)
    }

    interface Repository{
        fun getTopScores() : List<HighscoreEntity>
    }
}