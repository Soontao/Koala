# ![](https://res.cloudinary.com/digf90pwi/image/upload/c_scale,h_30/v1525442687/icons8-koala-filled-100_ootlj9.png) Koala 

[![CircleCI](https://circleci.com/gh/Soontao/Koala/tree/master.svg?style=shield)](https://circleci.com/gh/Soontao/Koala/tree/master) [![codecov](https://codecov.io/gh/Soontao/Koala/branch/master/graph/badge.svg)](https://codecov.io/gh/Soontao/Koala)

Java middleware for handling high loads in a short time

## Overview

![Arch](https://assets.processon.com/chart_image/5b38cd62e4b045a5a30e4f48.png)

## Concepts

Some concepts appeared in this project.

* Koala, is an abstract framework, just define a lifecycle to sync data from local to remote, and expose APIs for external system.
* Koala instance, designed as Data Access Object, users can use it access data from local & remote transparently.
* Koala reference, for control data lifecycle between local and remote.
* koala scheduler, run periodic sync data to remote.
* Koala processors, developers need to develop processors for access local & remote api, throw exceptions and more, Koala lifecycle is implemented by these processors.

## Limitation

* Users need test remote system performance manually, and use the test result to config koala
