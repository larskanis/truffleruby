exclude :test_many_fibers, "OOM"
exclude :test_fatal_in_fiber, "inter-test dependency"
exclude :test_stack_size, "RubyVM-specific"
exclude :test_no_valid_cfp, "needs investigation"
exclude :test_fiber_transfer_segv, "needs investigation"
exclude :test_gc_root_fiber, "needs investigation"
exclude :test_many_fibers_with_threads, "needs investigation"
