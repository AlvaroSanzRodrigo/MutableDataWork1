package io.github.alvarosanzrodrigo.livedataandroid

import android.arch.lifecycle.Observer
import android.arch.lifecycle.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var button: Button
    private val currentNumber: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        setListeners()
        currentNumber.value=0

        val numberObserver = Observer<Int> { newNumber ->
            // Update the UI, in this case, a TextView.
            textView.text = "$newNumber"
        }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        currentNumber.observe(this, numberObserver)
    }

    fun setListeners(){
        button.setOnClickListener {
            currentNumber.setValue(currentNumber.value?.plus(1))
        }
    }

}
