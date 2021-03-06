package org.kontinuity.catapult.service.github.spi;

import java.io.IOException;

import org.kontinuity.catapult.service.github.api.GitHubRepository;
import org.kontinuity.catapult.service.github.api.GitHubService;
import org.kontinuity.catapult.service.github.api.GitHubWebhook;

/**
 * SPI on top of GitHubService to provide with operations that are not exposed
 * in the base API (e.g., for testing purpose).
 */
public interface GitHubServiceSpi extends GitHubService {

    /**
     * Creates a repository with the given information.
     *
     * @param repositoryName - the name of the repository
     * @param description - the repository description
     * @param homepage - the homepage url
     * @param hasIssues - flag for whether issue tracking should be created
     * @param hasWiki - flag for whether a wiki should be created
     * @param hasDownloads - flag for whether downloads should be created
     * @return the created {@link GitHubRepository}
     * @throws IOException
     * @throws IllegalArgumentException
     */
    GitHubRepository createRepository(String repositoryName, String description, String homepage,
        boolean hasIssues, boolean hasWiki, boolean hasDownloads) throws IOException, IllegalArgumentException;


    /**
     * Delete a repository specified by its value object representation.
     *
     * @param repository - the value objct the represents the Gitub repository
     * @throws IllegalArgumentException
     */
    void deleteRepository(final GitHubRepository repository) throws IllegalArgumentException;
    
    /**
     * Deletes a webhook in a specific GitHub repository
     * 
     * @param repository - the value object that represents the GitHub repository
     * @param webhook - the value object that represents the GitHub webhook
     * @throws IllegalArgumentException If either parameter is unspecified
     */
    void deleteWebhook(final GitHubRepository repository, GitHubWebhook webhook) throws IllegalArgumentException;
    
}
