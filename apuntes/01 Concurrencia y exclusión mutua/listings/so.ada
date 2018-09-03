package Ada.Synchronous_Task_Control is
  type Suspension_Object is limited private;
  procedure Set_True(S : in out Suspension_Object);
  procedure Set_False(S : in out Suspension_Object);
  function Current_State(S : Suspension_Object)
    return Boolean;
  procedure Suspend_Until_True(
    S : in out Suspension_Object);
private
  -- not specified by the language
end Ada.Synchronous_Task_Control;