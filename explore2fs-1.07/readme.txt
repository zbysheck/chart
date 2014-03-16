    explore2fs, the Linux file system utility for Windows NT
    Copyright (C) 2005  John Newbigin

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program; if not, write to the Free Software
    Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.


What is this program?
---------------------

This is an explorer like program which can read and interpret the second
extended file system (EXT2) and the third extended filesystem (EXT3).


Why is it written in Delphi?
----------------------------

I like Delphi.  It allows great user interfaces to be designed in a very short
amount of time.  The problem is however that processing large amounts of data,
or performing pointer arithmetic is difficult and clumsy.  So I decided that I
would take the challenge and write a useful program in Delphi.

Where did the name Explore2fs come from?
----------------------------------------

My first working name was ex2fs explorer.  It was shortened to make it easier
to write.

Why is this not a filesystem driver?
------------------------------------

Now it is.  I have developed an IFS for Windows NT/2K/XP/2K3.  See
http://uranus.it.swin.edu.au/~jn/linux/ext2ifs.htm for details.


What OS does it run on?
-----------------------

Windows 95
Windows 98
Windows ME
Windows NT
Windows 2000
Windows XP
Windows 2003 Server

Win32s is not supported


Has it been tested?
-------------------

Read support has been extensivly tested on many machines, IDE and SCSI.  It
works with all blocks sizes, 1k, 2k and 4k.

Some people have problems under 95/98/ME.  Please read the section on Windows 95
further down.

I something doesn't seem to be working, enable full debugging and send me a copy
of the debug log along with a description of the problem and I will try and fix
it.


What doesn't work?
------------------

For a more complete list of features, look at the changes file.


Special Information for Windows 95/98/ME
----------------------------------------

The disk reading implementation for Windows 95/98/ME is clumsy at best.  For
more information read this web page
http://uranus.it.swin.edu.au/~jn/linux/diskio/index.htm

As of 1.00 pre2, there is support for extended interupt 13.  This should solve
most problems with large disks under 95/98/ME but there are still some issues.
People who use fance partitioning tools (like PartitionMagic) often have
problems.

All disks should have a boot sector.  For hard disks this will not be a problem,
but if you have a linux floppy, you will have to copy a standard DOS boot
sector onto it.  This can be done by the following commands:
- Insert a dos disk in fd0 (or whatever your floppy drive is)
- type: dd if=/dev/fd0 of=/tmp/bootsector.dos bs=512 count=1
- Insert your Linux disk, or type: mke2fs /dev/fd0 (to create a new one)
- type: dd of=/dev/fd0 if=/tmp/bootsector.dos bs=512 count=1

And you should be right.

Note: DO NOT DO THIS TO YOUR HARD DISK! or you will end up crying.

Windows NT/XP/2K/2K3
--------------------

As of version 1.00 pre4 there is support for NT Native IO.  This bypasses the
Win32 API and uses NTDLL.DLL directly.  This means that the partition devices
used internaly by NT can be used.  This means that my parition scan code is not
used which should solve problems people have with Partition Magic.  The down
side is that you don't know the partition type, number or size.  This means that
the partitions are labeled wrong (or at least differently) to the previous
method.

Using user names and group names
--------------------------------
If you want to display user names and group names instead of id's, you can
select a passwd file and group file from the options dialog.  First you should
export the appropriate files from you linux partition.  If you don't want to use
this feature, remove the file names in the options dialog.

Note that the same user names and gropus are used for all partitions.

Floppy support
--------------
If you want to use floppy support, you will have to make sure that floppy
support is selected under the general options.  The floppy drive will show up as
fda0. If you have a LS-120 drive, or other non-floppy floppy drive (ie. not on
the floppy bus (meaning IDE or SCSI)) then you may have it partitioned.  If
partitions are found, they will show up as fda1, fda2 etc.


Where do I find the latest version?
-----------------------------------

My linux homepage is at http://uranus.it.swin.edu.au/~jn/linux/
This page will contain the latest information and versions of all my linux
related software.

How do I contact the author?

I can be contacted by e-mail: jn@it.swin.edu.au
or snail-mail
  John Newbigin
  8 Robinson Ct.
  North Bayswater  3151
  Vic   Australia


What if I want to send you money?
---------------------------------

I by no means expect people to send me money, but if you feel like contributing
financially then you can use PayPal to send money to jn@it.swin.edu.au

You might also want to send me an email letting me know so I can collect the
money.

