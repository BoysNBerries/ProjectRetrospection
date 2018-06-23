/**
 * Created by Taylor Lanclos on 6/18/18
 */
package dev.boysnberries.projectretrospection.data.database.entity

import android.arch.persistence.room.*
import java.io.Serializable


@Entity(tableName = "question_types", indices = [Index(value = ["tag"], unique = true)])
data class QuestionType(
        @PrimaryKey(autoGenerate = true) var id: Long?,
        @ColumnInfo(name = "tag") var tag: String
) : Serializable {
    companion object {
        fun default() = QuestionType(null, "")
    }
}
