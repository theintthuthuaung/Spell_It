package com.example.animalsound

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        displayData()
    }
    fun displayData() {
        val animalSound = ArrayList<Animal>()
        animalSound.add(Animal(R.drawable.a1 , "Dog"))
        animalSound.add(Animal(R.drawable.a2 , "Cat"))
        animalSound.add(Animal(R.drawable.a3 , "Tiger"))
        animalSound.add(Animal(R.drawable.a4 , "Elephant"))
        animalSound.add(Animal(R.drawable.a5 , "Parrot"))
        animalSound.add(Animal(R.drawable.a6 , "Sky"))

        val recycler_view = findViewById<RecyclerView>(R.id.sound_list)
        val adapter = AnimalAdapter(animalSound , this@MainActivity)

        recycler_view.layoutManager = GridLayoutManager(this@MainActivity , 2)
        recycler_view.adapter = adapter
    }
}