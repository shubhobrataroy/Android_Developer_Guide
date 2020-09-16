package com.shubhobrata.roy.androiddeveloperguide.data

import android.content.Context
import android.os.Build
import android.os.Build.VERSION_CODES
import com.shubhobrata.roy.androiddeveloperguide.domain.repository.AndroidInfoRepository
import java.lang.reflect.Field


class AndroidInfoRepositoryImpl(context: Context) : AndroidInfoRepository {
    override fun getAllAndroidVersions(): List<Pair<String, Int>> {

        val builder = StringBuilder()
        builder.append("android : ").append(Build.VERSION.RELEASE)

        val fields: Array<Field> = VERSION_CODES::class.java.fields
        val versionList = ArrayList<Pair<String, Int>>(fields.size)

        for (field in fields) {
            val fieldName: String = field.getName()
            var fieldValue = -1
            try {
                fieldValue = field.getInt(Any())
            } catch (e: IllegalArgumentException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            } catch (e: NullPointerException) {
                e.printStackTrace()
            }
            versionList.add(fieldName to fieldValue)
        }
        return versionList
    }

    override fun getLatestAndroidVersion(): Pair<String, Int> {
        return "Pie" to 29
    }

    override fun getNameByVersionCode(versionCode: Int): String {

        val builder = StringBuilder()
        builder.append("android : ").append(Build.VERSION.RELEASE)

        val fields: Array<Field> = VERSION_CODES::class.java.fields
        for (field in fields) {
            val fieldName: String = field.getName()
            var fieldValue = -1
            try {
                fieldValue = field.getInt(Any())
            } catch (e: IllegalArgumentException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            } catch (e: NullPointerException) {
                e.printStackTrace()
            }
            if (fieldValue == versionCode)
                return fieldName

        }
        return ""
    }


}