package com.sajid.hilt.intro

import android.content.Context
import com.sajid.hilt.intro.repo.MailClient
import com.sajid.hilt.intro.repo.MailClientImp
import com.sajid.hilt.intro.repo.SettingsRepo
import com.sajid.hilt.intro.repo.SettingsRepoImp
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext


//@Module
//@InstallIn(ViewModelComponent::class)
//abstract class SettingsDi {
//
//    @Binds
//    abstract fun provideAppSettings(appSettings: SettingsRepoImp): SettingsRepo
//
//}

@Module
@InstallIn(ViewModelComponent::class)
object MailDi {
    @Provides
    fun provideEmailClient(@ApplicationContext context: Context): MailClient =
        MailClientImp(context)

}

