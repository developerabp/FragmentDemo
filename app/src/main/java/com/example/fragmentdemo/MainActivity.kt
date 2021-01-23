package com.example.fragmentdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fragmentdemo.ArticleFragment.Companion.ARG_POSITION
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), IActivity {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.setContentView(R.layout.activity_main)


        if (isTwoLayoutPan().not()) {


            savedInstanceState?.let { return } // For if already added


            val headlineFragment = HeadlineFragment()


            headlineFragment.arguments = intent.extras


            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, headlineFragment)
                .commit()
        }
    }


    override fun onArticleSelected(articlePosition: Int) {

        val articleFragment =
            supportFragmentManager.findFragmentById(R.id.article_fragment) as ArticleFragment?

        articleFragment?.let {

            articleFragment.updateArticleView(articlePosition)

            return
        }

        // else

        val newFragment = ArticleFragment()

        val args = Bundle()
        args.putInt(ARG_POSITION, articlePosition)

        newFragment.arguments = args

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, newFragment)
            .addToBackStack(null)
            .commit()
    }


    private fun isTwoLayoutPan(): Boolean {

        layout_two_pan?.let {
            return true
        }

        return false
    }

    override fun onStart() {
        super.onStart()

        println("Lifecycle => OnStart")
    }


    override fun onStop() {
        super.onStop()

        println("Lifecycle => OnStop")
    }


    override fun onPause() {
        super.onPause()

        println("Lifecycle => OnPause")
    }


    override fun onResume() {
        super.onResume()

        println("Lifecycle => OnResume")
    }


    override fun onRestart() {
        super.onRestart()

        println("Lifecycle => OnRestart")
    }
}