package com.javohirbekcoder.puzzle15mvp.screens.game


/*
Created by Javohirbek on 18.05.2023 at 11:10
*/
interface GameContract {
    interface Presenter{
        fun shuffle()
    }

    interface View{
        fun init()
        fun loadViewsAndHandleClicks()
        fun loadGame(list: List<Int>)
        fun isGameOver():Boolean
    }

    interface Repository{
        fun loadNumbers():List<Int>
        fun getShuffleNumbers():List<Int>
    }
}