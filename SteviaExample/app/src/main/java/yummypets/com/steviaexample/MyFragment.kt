package yummypets.com.steviaexample

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MyFragment : Fragment() {

    lateinit var myView: MyView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        myView = MyView(inflater.context)
        return myView
    }
}
