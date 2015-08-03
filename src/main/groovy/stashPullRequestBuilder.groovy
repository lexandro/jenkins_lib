import javaposse.jobdsl.dsl.helpers.triggers.TriggerContext

/*
 * Simple PoC method that take a string and a number and add and echo shell command as job step.
 *
 * Example:
 *
 * job('PRTestJob') {
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
TriggerContext.metaClass.stashPullRequestBuilder = { String cronData,
                                                     String stashHostUrl,
                                                     String userName,
                                                     String userPassword,
                                                     String projectCodeTLA,
                                                     String repoName,
                                                     String buildPhrase,

                                                     Boolean chkDestinationCommit,
                                                     Boolean chkMergeable,
                                                     Boolean chkNotConflicted,
                                                     Boolean onlyBuildOnCommentFlag ->
    triggerNodes << new NodeBuilder().'stashpullrequestbuilder.stashpullrequestbuilder.StashBuildTrigger' {
        'spec' cronData
        'cron' cronData
        'stashHost' stashHostUrl
        'username' userName
        'password' userPassword
        'projectCode' projectCodeTLA
        'repositoryName' repoName
        'ciBuildPhrases' buildPhrase

        'checkDestinationCommit' chkDestinationCommit
        'checkMergeable' chkMergeable
        'checkNotConflicted' chkNotConflicted
        'onlyBuildOnComment' onlyBuildOnCommentFlag
    }
}

