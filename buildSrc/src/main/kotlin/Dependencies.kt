object Deps {
    object JUnit {
        const val Version = "4.13.2"
        const val JUnit = "junit:junit:$Version"
    }

    object AndroidX {
        object Fragment {
            const val Version = "1.4.1"
            const val FragmentKtx = "androidx.fragment:fragment-ktx:$Version"
        }

        object Activity {
            const val Version = "1.3.1"
            const val Activity = "androidx.activity:activity-ktx:$Version"
        }

        object Core {
            const val Version = "1.7.0"
            const val Core = "androidx.core:core-ktx:$Version"
        }

        object AppCompat {
            const val Version = "1.4.2"
            const val AppCompat = "androidx.appcompat:appcompat:$Version"
        }

        object ConstraintLayout {
            const val Version = "2.1.4"
            const val ConstraintLayout = "androidx.constraintlayout:constraintlayout:$Version"
        }

        object Test {
            object JUnit {
                const val Version = "1.1.3"
                const val JUnit = "androidx.test.ext:junit:$Version"
            }

            object Espresso {
                const val Version = "3.4.0"
                const val Core = "androidx.test.espresso:espresso-core:$Version"
            }
        }
    }

    object Google {
        object Android {
            object Material {
                const val Version = "1.6.1"
                const val Material = "com.google.android.material:material:$Version"
            }
        }
    }

    object JetBrains {
        object KotlinX {
            object Coroutines {
                const val Version = "1.6.2"
                const val Core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$Version"
            }
        }
    }
}