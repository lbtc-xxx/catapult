package org.kontinuity.catapult.service.github.api;

import java.net.URI;

/**
 * Value object representing a repository in GitHub
 *
 * @author <a href="mailto:alr@redhat.com">Andrew Lee Rubinger</a>
 */
public interface GitHubRepository {

    /**
     * @return the "git" protocol transport URL
     */
    String getGitTransportUrl();

    /**
     * @return the full repository name in form "owner/repoName"
     */
    String getFullName();

    /**
     * @return the github.com page for the repository
     */
    URI getHomepage();
}
