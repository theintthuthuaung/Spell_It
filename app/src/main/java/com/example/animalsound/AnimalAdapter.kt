package com.example.animalsound

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class AnimalAdapter (sound:ArrayList<Animal> , var context:Context) : RecyclerView.Adapter<AnimalAdapter.ViewHolder>(){

    var sound:ArrayList<Animal>
    init {
        this.sound = sound
    }

    class  ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        var image:ImageView
        var name:TextView
        var card:CardView
        lateinit var text2speech:TextToSpeech
        init {
            image = itemView.findViewById(R.id.animal_image)
            name = itemView.findViewById(R.id.animal_name)
            card = itemView.findViewById(R.id.animal_card)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layout:View
        layout = LayoutInflater.from(context).inflate(R.layout.animalsound_item , parent , false)
        return ViewHolder(layout)
    }

    override fun getItemCount(): Int {
       return sound.size
    }

    @SuppressLint("NewApi")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var itemData = sound[position]
        holder.name.text = itemData.name
        holder.image.setImageResource(itemData.image!!)

        holder.card.setOnClickListener {
            var alert = Dialog(context)
            alert.setContentView(R.layout.sond_alert)

            var name = alert.findViewById<TextView>(R.id.alert_name)
            var image = alert.findViewById<ImageView>(R.id.alert_image)
            var spell = alert.findViewById<Button>(R.id.spell_btn)
            var done = alert.findViewById<Button>(R.id.done_btn)

            name.text = itemData.name
            image.setImageResource(itemData.image!!)

            alert.show()

            spell.setOnClickListener {
                holder.text2speech = TextToSpeech(context , TextToSpeech.OnInitListener { status ->
                    if (status == TextToSpeech.SUCCESS){
                        holder.text2speech.language = Locale.UK
                        holder.text2speech.speak(itemData.name , TextToSpeech.QUEUE_FLUSH , null , null)
                    }
                })
            }

            done.setOnClickListener {
                alert.dismiss()
            }
        }
    }
}
