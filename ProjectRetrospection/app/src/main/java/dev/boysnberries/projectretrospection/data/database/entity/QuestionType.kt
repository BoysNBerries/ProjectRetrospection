/**
 * Created by Taylor Lanclos on 6/18/18
 */
package dev.boysnberries.projectretrospection.data.database.entity

import android.arch.persistence.room.*
import java.io.Serializable


@Entity(tableName = "question_types")
data class QuestionType(
        @PrimaryKey(autoGenerate = true) val id: Long?,
        @ColumnInfo(name = "tag") val tag: String
) : Serializable {
    constructor() : this(null, "")
}
