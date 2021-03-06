package parts.jobs

import cd.go.contrib.plugins.configrepo.groovy.dsl.Jobs

return new Jobs().job('test') {
  environmentVariables = [
    '1varWhichIsNotJavaValidIdentifier': 'unknown',
    LD_LIBRARY_PATH                    : '.',
  ]
  resources = ['linux']
  runInstanceCount = 7
  timeout = 5
  artifacts {
    test {
      destination = 'dest'
      source = 'src'
    }
    build {
      source = 'bin'
    }
  }
  properties {
    property('perf') {
      source = 'test.xml'
      xpath = 'substring-before(//report/data/all/coverage[starts-with(@type,\'class\')]/@value, \'%\')'
    }
  }
  tabs {
    tab('test') {
      path = 'results.xml'
    }
  }
  tasks {
    exec {
      commandLine = ['make', '-j3', 'docs', 'install']
      runIf = 'any'
      workingDir = 'some-dir'
    }
  }
}
