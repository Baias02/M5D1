package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), Contract {

    private lateinit var binding: ActivityMainBinding
    var presenter = Presenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.init(this)
        initResult()
    }

    private fun initResult() {
        with(binding) {
            incrementBtn.setOnClickListener {
                presenter.increment()
                if (resultTvt.text == "10") {
                    Toast.makeText(this@MainActivity, "Поздравляем", Toast.LENGTH_LONG).show()
                }
                if (resultTvt.text == "15") {
                    Toast.makeText(this@MainActivity, "Успех", Toast.LENGTH_LONG).show()
                    resultTvt.setTextColor(Color.GREEN)
                } else {
                    resultTvt.setTextColor(Color.BLACK)
                }
                decrementBtn.setOnClickListener {
                    presenter.decrement()
                    if (resultTvt.text == "10") {
                        Toast.makeText(this@MainActivity, "Поздравляем", Toast.LENGTH_LONG).show()
                    }
                    if (resultTvt.text == "15") {
                        Toast.makeText(this@MainActivity, "Успех", Toast.LENGTH_LONG).show()
                        resultTvt.setTextColor(Color.GREEN)
                    } else {
                        resultTvt.setTextColor(Color.BLACK)
                    }
                }
            }
        }
    }

    override fun updateText(count: Int) {
        binding.resultTvt.text = count.toString()
    }
}

