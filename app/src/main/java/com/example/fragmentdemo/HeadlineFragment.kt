package com.example.fragmentdemo

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.fragment.app.ListFragment
import androidx.navigation.fragment.findNavController

class HeadlineFragment : ListFragment() {

    private lateinit var mCallback: IActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        retainInstance = true

        listAdapter = ArrayAdapter(
                requireActivity(),
                android.R.layout.simple_list_item_activated_1,
                RawData.list
        )
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)

        this.mCallback = context as IActivity

        println("OnAttach")
    }


    override fun onListItemClick(listView: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(listView, v, position, id)

        this.mCallback.onArticleSelected(position)

        getListView().setItemChecked(position, true)
    }
}