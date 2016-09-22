# massive_collections
Replacement for Java Collections classes, when extremely large collections are required.

## Overview
This library arose from a project where there was a need to store an extremely large number of elements in a list structure. It was found that the memory available in the JVM would quickly be exhausted when using a regular List, like ArrayList; turns out that the problem was the -Xmx flag when running a Java program, which was set by 512MB. Although increasing the value of the -Xmx flag would allow the application to run for a little longer, there was still a limit on how much data could be held in memory, that limit being the amount of physical memory installed and how much of that is made available to the JVM. I'd have to reconfirm this, but I believe that the 32-bit JVM can have a maximum of ~2GB memory, which is essentially 'Integer.MAX_VALUE' number of bytes.

While physical memory is a limited resource, disk space can almost be thought of as being limitless. Storing data in memory-mapped files would provide the benefit of virtually unlimited space, with a small performance hit as the OS pages data from disk into memory.