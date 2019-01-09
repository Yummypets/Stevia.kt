package yummypets.com.steviaexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_my)

        val fragment = MyFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.containerFragment, fragment)
            .commit()
    }
}
