package net.simplifiedcoding.mvvmsampleapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import net.simplifiedcoding.mvvmsampleapp.data.db.entities.Row

@Dao
interface QuoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllQuotes(rows : List<Row>)

    @Query("SELECT * FROM `Row`")
    fun getQuotes() : LiveData<List<Row>>

}