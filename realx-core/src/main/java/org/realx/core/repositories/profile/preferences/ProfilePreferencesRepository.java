package org.realx.core.repositories.profile.preferences;

import org.realx.core.entities.profile.preferences.ProfilePreferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfilePreferencesRepository extends JpaRepository<ProfilePreferences, Long> {

}
