import javaposse.jobdsl.dsl.helpers.step.*

/*
 * Simple PoC method that take a string and a number and add and echo shell command as job step.
 *
 * Example:
 *
 * job('dockerBuildJob') {
 *   steps {
 *       dockerBuild('tcp://docker.host.test',
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
StepContext.metaClass.dockerBuild = { String serverUri,
                                      String serverCredentialsId,
                                      String registryUrl,
                                      String registryCredentialsId,
                                      String repositoryName,
                                      String repositoryTag,
                                      Boolean skipPushToRegistry,
                                      Boolean noCacheForBuild,
                                      Boolean forcePullImage,
                                      Boolean skipBuildImage,
                                      Boolean createFingerPrintForImage,
                                      Boolean skipDecorateBuildName,
                                      Boolean skipToTagLatest,
                                      String pathToDockerfile ->
    stepNodes << new NodeBuilder().'com.cloudbees.dockerpublish.DockerBuilder' {
        'repoName' repositoryName
        'repoTag' repositoryTag
        'server' {
            'uri' serverUri
            'credentialsId' serverCredentialsId
        }
        'registry' {
            'url' registryUrl
            'credentialsId' registryCredentialsId

        }
        'skipPush' skipPushToRegistry
        'noCache' noCacheForBuild
        'forcePull' forcePullImage
        'skipBuild' skipBuildImage
        'createFingerPrint' createFingerPrintForImage
        'skipDecorate' skipDecorateBuildName
        'skipTagLatest' skipToTagLatest
        'dockerFilePath' pathToDockerfile

    }
}

