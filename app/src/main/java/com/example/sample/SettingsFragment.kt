package com.example.sample

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sample.adapter.MyAdapter


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SettingsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SettingsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val settingsNameArray =
            listOf<String>(UtilsString.MY_PROFILE, UtilsString.MY_REQUESTS,
                UtilsString.MY_OFFERINGS, UtilsString.MY_RECOMMENDATIONS, UtilsString.SUPPORT)

        val recyclerView = getView()?.findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = MyAdapter()
        adapter.setDataCustom(settingsNameArray)
        recyclerView?.layoutManager  = LinearLayoutManager(activity,
            LinearLayoutManager.VERTICAL, false)
        recyclerView?.adapter = adapter

        val imageView = getView()?.findViewById<ImageView>(R.id.big_profile_img)
        imageView?.alpha = 0.3F

        val bounce = AnimationUtils.loadAnimation(context, R.anim.bounce)
        bounce.repeatMode = Animation.REVERSE
        val bounce2 = AnimationUtils.loadAnimation(context, R.anim.bounce2)
        bounce2.repeatMode = Animation.REVERSE
        val bounce3 = AnimationUtils.loadAnimation(context, R.anim.bounce3)
        bounce3.repeatMode = Animation.REVERSE

        val s = AnimationSet(true) //false means don't share interpolators
        s.addAnimation(bounce)
        s.addAnimation(bounce2)
        s.addAnimation(bounce3)
        s.duration = (30000).toLong()
        imageView?.startAnimation(s)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SettingsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SettingsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}