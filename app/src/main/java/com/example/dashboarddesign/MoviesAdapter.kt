package com.example.dashboarddesign

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.makeramen.roundedimageview.RoundedImageView

class MoviesAdapter(
    private val movies: List<Movie>
): RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    class MoviesViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        val imagePoster: RoundedImageView = view!!.findViewById(R.id.image_poster)
        val textName: TextView = view!!.findViewById(R.id.text_name)
        val textCategory: TextView = view!!.findViewById(R.id.text_category)
        val textReleaseDate: TextView = view!!.findViewById(R.id.text_release_date)
        val ratingBar: RatingBar = view!!.findViewById(R.id.rating_bar)

        fun bind(movie: Movie) {
            imagePoster.setImageResource(movie.poster)
            textName.text = movie.name
            textCategory.text = movie.category
            textReleaseDate.text = movie.releaseDate
            ratingBar.rating = movie.rating
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val adapter = LayoutInflater.from(parent.context).inflate(R.layout.item_container_movie, parent, false)
        return MoviesViewHolder(adapter)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int = movies.size

}