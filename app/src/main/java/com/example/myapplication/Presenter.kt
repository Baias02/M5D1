package com.example.myapplication

import android.graphics.Color

class Presenter {

    var model = Model()
    lateinit var view: Contract

    fun increment() {
        model.increment()
        view.updateText(model.count.toString())

        if (model.count == 10) {
            view.showToast("Поздравляем")
        }

        if (model.count == 15) {
            view.textColor(Color.GREEN)
        } else {
            view.textColor1()
        }
    }

    fun init(view: Contract) {
        this.view = view
    }

    fun decrement() {
        model.decrement()
        view.updateText(model.count.toString())
        view.textColor1()
    }

}
