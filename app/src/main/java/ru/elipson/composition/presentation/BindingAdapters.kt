package ru.elipson.composition.presentation

import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("countOfWriteAnswers")
fun bindCountOfWriteAnswers(textView: TextView, count: Int) {
    textView.text = "Верных ответов $count"
}

@BindingAdapter("percentOfRightAnswers")
fun bindPercentOfRightAnswers(progressBar: ProgressBar, percent: Int) {
    progressBar.setProgress(percent, true)
}