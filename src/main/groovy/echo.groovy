import javaposse.jobdsl.dsl.helpers.step.*


/*
 * Simple PoC method that take a string and a number and add and echo shell command as job step.
 *
 * Example:
 *   job {
 *     steps {
 *       echo('some text', 123)
 *     }
 *   }
 */
StepContext.metaClass.echo = { String strng, Long nmbr ->
    shell('echo string:' + strng + ', number:' + nmbr)
}

