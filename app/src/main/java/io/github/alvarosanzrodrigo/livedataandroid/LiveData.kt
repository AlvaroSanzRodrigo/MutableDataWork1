package io.github.alvarosanzrodrigo.livedataandroid

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import android.widget.ToggleButton

class LiveData : AppCompatActivity() {

    private val trabajo: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    private val aprobar: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    private val edad: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    private lateinit var textViewTrabajo: TextView
    private lateinit var textViewAprobar: TextView
    private lateinit var textViewEdad: TextView

    private lateinit var toggleButton: ToggleButton
    private lateinit var toggleButton2: ToggleButton

    private lateinit var editText: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)
        bindView()
        setObservers()
        setListeners()
    }

    private fun bindView() {
        textViewTrabajo = findViewById(R.id.textViewTrabajo)
        textViewAprobar = findViewById(R.id.textViewAprobar)
        textViewEdad = findViewById(R.id.textViewEdad)
        toggleButton = findViewById(R.id.toggleButton)
        toggleButton2 = findViewById(R.id.toggleButton2)
        editText = findViewById(R.id.editText)
    }

    private fun setObservers() {
        val trabajoObserver = Observer<String> { newTrabajo ->
            // Update the UI, in this case, a TextView.
            textViewTrabajo.text = "$newTrabajo trabajo en casa"
        }

        val aprobarObserver = Observer<String> { newAprobar ->
            // Update the UI, in this case, a TextView.
            textViewAprobar.text = "$newAprobar apruebo"
        }

        val edadObserver = Observer<String> { newEdad ->
            // Update the UI, in this case, a TextView.
            textViewEdad.text = "tengo $newEdad years"
        }

        trabajo.observe(this, trabajoObserver)
        aprobar.observe(this, aprobarObserver)
        edad.observe(this, edadObserver)
    }

    private fun setListeners() {
        toggleButton.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked)
                trabajo.value = "Si"
            else
                trabajo.value = "No"
        }

        toggleButton2.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked)
                aprobar.value = "Si"
            else
                aprobar.value = "No"
        }

        val textWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                edad.value = editText.text.toString()
            }
        }

        editText.addTextChangedListener(textWatcher)


    }
}

