import javaposse.jobdsl.dsl.helpers.step.*


/*
 * Simple PoC method that take a string and a number and add and echo shell command as job step.
 *
 * Example:
 *   job('jobName') {
 *     steps {
 *       echo('some text', 123)
 *     }
 *   }
 */
StepContext.metaClass.dockerBuild = { String serverUri, String serverCredentialsId,
                                      String registryUrl, String registryCredentialsId,
                                      String repoName,
                                      String repoTag,
                                      Boolean skipPush,
                                      Boolean noCache,
                                      Boolean forcePull,
                                      Boolean skipBuild,
                                      Boolean createFingerPrint,
                                      Boolean skipDecorate,
                                      Boolean skipTagLatest,
                                      String dockerFilePath ->
    stepNodes << new NodeBuilder().'com.cloudbees.dockerpublish.DockerBuilder' {
        'repoName' repoName
        'repoTag' repoTag
        'server' {
            'uri' serverUri
            'credentialsId' serverCredentialsId
        }
        'registry' {
            'url' registryUrl
            'credentialsId' registryCredentialsId

        }
        'skipPush' skipPush
        'noCache' noCache
        'forcePull' forcePull
        'skipBuild' skipBuild
        'createFingerPrint' createFingerPrint
        'skipDecorate' skipDecorate
        'skipPush' skipPush
        'skipTagLatest' skipTagLatest
        'dockerFilePath' dockerFilePath

    }
}

