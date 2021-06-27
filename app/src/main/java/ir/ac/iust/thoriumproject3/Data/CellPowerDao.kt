package ir.ac.iust.thoriumproject3.Data


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ir.ac.iust.thoriumproject3.Data.CellPower

@Dao
interface CellPowerDao {
    @Query("SELECT * FROM CellPower")
    fun getAll(): List<CellPower>

    @Query("SELECT * FROM CellPower WHERE id IN (:infoIds)")
    fun loadAllByIds(infoIds: IntArray): List<CellPower>

//    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
//            "last_name LIKE :last LIMIT 1")
//    fun findByName(first: String, last: String): CellPower

    @Insert
    fun insert(vararg info: CellPower)

    @Delete
    fun delete(power: CellPower)
}