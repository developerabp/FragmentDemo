package com.example.fragmentdemo

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_first.*

class ArticleFragment : Fragment() {


    var mCurrentPosition = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        println("Lifecycle Fragment => OnCreateView")

        return inflater.inflate(R.layout.fragment_first, container, false)
    }


    override fun onStart() {
        super.onStart()

        println("Lifecycle Fragment => OnStart")

        arguments?.let { nsArg ->
            mCurrentPosition = nsArg.getInt(ARG_POSITION)
        }

        updateArticleView(mCurrentPosition)
    }


    fun updateArticleView(position: Int) {

        textview_first.text = RawData.details[position]

        this.mCurrentPosition = position
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)

        println("Lifecycle Fragment => onAttach")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        println("Lifecycle Fragment => OnCreate")

        this.retainInstance = true
    }


    companion object {
        const val ARG_POSITION = "position"
    }
}