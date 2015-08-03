import javaposse.jobdsl.dsl.helpers.triggers.TriggerContext


/*
 * Simple PoC method that take a string and a number and add and echo shell command as job step.
 *
 * Example:
 *
 * job('dockerBuildJob') {
 *   triggers {
 *       stashPullRequestBuilder ('tcp://docker.host.test',
 *               'docker_host',
 *               'http://regisry.url',
 *               'registry_credentials',
 *               'testRepo',
 *               'testTag',
 *               true,
 *               true,
 *               true,
 *               true,
 *               true,
 *               true,
 *               true,
 *               'docker_dir')
 *    }
 * }
 */
TriggerContext.metaClass.stashPullRequestBuilder = { String cron,
                                                     String stashHost,
                                                     String userName,
                                                     String password,
                                                     String projectCode,
                                                     String repositoryName,
                                                     String ciBuildPhrases,

                                                     Boolean checkDestinationCommit,
                                                     Boolean checkMergeable,
                                                     Boolean checkNotConflicted,
                                                     Boolean onlyBuildOnComment ->
    stepNodes << new NodeBuilder().'stashpullrequestbuilder.stashpullrequestbuilder.StashBuildTrigger' {
        'spec' cron
        'cron' cron
        'stashHost' stashHost
        'userName' userName
        'password' password
        'projectCode' projectCode
        'repositoryName' repositoryName
        'ciBuildPhrases' ciBuildPhrases

        'checkDestinationCommit' checkDestinationCommit
        'checkMergeable' checkMergeable
        'checkNotConflicted' checkNotConflicted
        'onlyBuildOnComment' onlyBuildOnComment

    }
}

