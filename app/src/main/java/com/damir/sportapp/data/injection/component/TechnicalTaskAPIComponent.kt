package com.damir.sportapp.data.injection.component

import com.damir.sportapp.data.injection.module.TechnicalTaskApiModule
import com.damir.sportapp.ui.presenter.MainPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [TechnicalTaskApiModule::class])
interface TechnicalTaskAPIComponent{
    fun inject(presenter: MainPresenter)
}