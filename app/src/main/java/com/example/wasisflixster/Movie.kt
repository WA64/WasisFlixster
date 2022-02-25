package com.example.wasisflixster

import com.codepath.asynchttpclient.AsyncHttpClient
import org.json.JSONArray

class Movie (
    val movieId: Int,
    private val posterPath: String,
    val title: String,
    val overView: String,
    private val backdropPath: String,

) {
    val posterImageUrl = "https://image.tmdb.org/t/p/w342/$posterPath"
    val backdropImageUrl = "https://image.tmdb.org/t/p/w342/$backdropPath"
    companion object {
        fun fromJsonArray(movieJsonArray: JSONArray): List<Movie> {
            val movies = mutableListOf<Movie>()
            for (i in 0 until movieJsonArray.length()){


                val movieJson = movieJsonArray.getJSONObject(i)

                movies.add(
                    Movie(
                        movieJson.getInt("id"),
                        movieJson.getString("poster_path"),
                        movieJson.getString("title"),
                        movieJson.getString("overview"),
                        movieJson.getString("backdrop_path")

                    )
                )
            }
            return movies

        }
    }
}