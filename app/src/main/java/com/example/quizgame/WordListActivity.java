package com.example.quizgame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quizgame.model.WordItem;

public class WordListActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_word_list);

      // สร้าง Layout manager
      LinearLayoutManager lm = new LinearLayoutManager(WordListActivity.this);

      // สร้าง Adapter object
      MyAdapter adapter = new MyAdapter();

      // เข้าถึง  RecyclerView ใน layout
      RecyclerView rv = findViewById(R.id.word_list_recycler_view);
      rv.setLayoutManager(lm); // กำหนด layout manager ให้กับ RecyclerView
      rv.setAdapter(adapter); // กำหนด adapter ให้กับ RecyclerView
   }
}

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

   private WordItem[] items = {
           new WordItem(R.drawable.apple, "APPLE","แอปเปิล"),
           new WordItem(R.drawable.avocado, "AVOCADO","อะโวคาโด"),
           new WordItem(R.drawable.banana, "BANANA","กล้วย"),
           new WordItem(R.drawable.cherry, "CHERRY","เชอรี่"),
           new WordItem(R.drawable.kiwi, "KIWI","กีวี"),
           new WordItem(R.drawable.mango, "MANGO","มะม่วง"),
           new WordItem(R.drawable.mangosteen, "MANGOSTEEN","มังคุด"),
           new WordItem(R.drawable.orange, "ORANGE","ส้ม"),
           new WordItem(R.drawable.pineapple, "PINEAPPLE","สับปะรด"),
           new WordItem(R.drawable.pomegranate, "POMEGRANATE","ทับทิม"),
           new WordItem(R.drawable.rambutan, "RAMBUTAN","เงาะ"),
           new WordItem(R.drawable.strawberry, "STRAWBERRY","สตรอว์เบอร์รี"),
           new WordItem(R.drawable.watermelon, "WATERMELON","แตงโม")
   };

   MyAdapter() {
   }

   @NonNull
   @Override
   public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View v = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_word, parent, false);
      MyViewHolder vh = new MyViewHolder(v);
      return vh;
   }

   @Override
   public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
      holder.imageView.setImageResource(items[position].imageResId);
      holder.wordTextView.setText(items[position].word);
      holder.wordTextView2.setText(items[position].word2);
   }

   @Override
   public int getItemCount() {
      return items.length;
   }

   static class MyViewHolder extends RecyclerView.ViewHolder {
      ImageView imageView;
      TextView wordTextView;
      TextView wordTextView2;

      MyViewHolder(@NonNull View itemView) {
         super(itemView);
         imageView = itemView.findViewById(R.id.image_view);
         wordTextView = itemView.findViewById(R.id.word_text_view);
         wordTextView2 = itemView.findViewById(R.id.word_text_view2);
      }
   }
}