# 4. Windows 10 ADR native support

Date: 2020-07-01

## Status

Accepted

Supercedes [3. For Windows 10 systems use it from Ubuntu:bash or VM](0003-for-windows-10-systems-use-it-from-ubuntu-bash-or-vm.md)

There exits native Windows support indeed [2. Discarded after no native Windows support](0002-discarded-after-no-native-windows-support.md)

## Context

Previously no working Git for Windows installation was available for testing and I was totally unaware of how git was used from Windows machines.

## Decision

Install on windows systems with Git for Windows following instructions from:
https://github.com/npryce/adr-tools/blob/master/INSTALL.md#windows-10

## Consequences

ADR tools should still be tested on Windows 7 systems, but there exists little risk of not working properly, since it's totally based on Git for Windows.
