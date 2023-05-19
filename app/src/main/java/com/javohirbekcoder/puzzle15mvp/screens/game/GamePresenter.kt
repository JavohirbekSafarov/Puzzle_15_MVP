package com.javohirbekcoder.puzzle15mvp.screens.game


/*
Created by Javohirbek on 18.05.2023 at 11:13
*/
class GamePresenter(
    private val repository: GameContract.Repository,
    private val view: GameContract.View
): GameContract.Presenter {

    init {
        repository.loadNumbers()
        view.init()
        view.loadViewsAndHandleClicks()
        view.loadGame(repository.getShuffleNumbers())
    }

    override fun shuffle() {
        view.loadGame(repository.getShuffleNumbers())
    }
}