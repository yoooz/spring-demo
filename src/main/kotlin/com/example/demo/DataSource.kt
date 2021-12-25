package com.example.demo

/**
 * dataSourceを変更するときに用いるアノテーション.
 */
@Target(
    AnnotationTarget.ANNOTATION_CLASS,
    AnnotationTarget.CLASS,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class DataSource(
    /**
     * defaultはSTG.
     *
     * @return enumで定義したdatasource
     */
    val value: DataSourceType = DataSourceType.STG
) {
    enum class DataSourceType {
        STG, PROD;

        companion object {
            fun from(raw: String?): DataSourceType {
                return values().firstOrNull { it.name.equals(raw, ignoreCase = true) } ?: STG
            }
        }
    }
}