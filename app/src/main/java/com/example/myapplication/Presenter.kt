package com.example.myapplication

class Presenter {

    var model = Model()
    lateinit var view: Contract

    fun increment() {
        model.increment()
        view.updateText(model.count)
    }

    fun init(view: Contract) {
        this.view = view
    }

    fun decrement() {
        model.decrement()
        view.updateText(model.count)
    }

}
