package com.yrds.iris.module.hs;

import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary;

public class WhsUsbAPI {
    public interface DeviceManager extends StdCallLibrary {

        // Definitions of the callback.
        public interface usb_hotplug_callback extends StdCallCallback {
            void invoke( int index, int hotplug_event );
        }

        public interface sleep_mode_callback extends StdCallCallback {
            void invoke( int index );
        }

        public interface error_callback extends StdCallCallback {
            void invoke( int index, int error_code );
        }

        public interface image_callback extends StdCallCallback {
            void invoke( int index, int type, Pointer image_ptr, int width, int height, Pointer template_ptr,
                    int length );
        }

        public interface match_callback extends StdCallCallback {
            void invoke( int index, Pointer id_array, int size, Boolean result );
        }

        String HS_MatchIdClips( Pointer id_array, int index );

        void About();

        int HS_SetUsbHotPlugCallback( usb_hotplug_callback on_usbhotplug );

        int HS_SetSleepModeCallback( sleep_mode_callback on_sleepmode );

        int HS_SetErrorCallback( error_callback on_error );

        int HS_SetImageCallback( image_callback on_capture );

        int HS_SetMatchCallback( match_callback on_match );

        int HS_Initialize();

        int HS_Finalize();

        String HS_StrError( int error_code );

        int HS_GetDeviceList();

        Boolean HS_IsSupportDoubleEye( int index );

        String HS_GetDeviceName( int index );

        Pointer HS_GetDeviceID( int index );

        int HS_GetTemplateSize( int index );

        int HS_GetImageWidth( int index );

        int HS_GetImageHeight( int index );

        int HS_GetVideoWidth( int index );

        int HS_GetVideoHeight( int index );

        int HS_GetDeviceStatus( int index );

        int HS_StartCapture( int index, int eye_count );

        int HS_StopCapture( int index );

        Pointer HS_CreateMatchRecord();

        int HS_SetTemplateA( Pointer record, byte[] template_ptr, int length );

        int HS_InsertTemplateB( Pointer record, byte[] template_ptr, int length, String id );

        void HS_ReleaseMatchRecord( Pointer record );

        int HS_StartMatch( int index, int mode, Pointer record );

        int HS_StopMatch( int index );

        Boolean HS_IsVideoEnabled( int index );

        int HS_SetVideoEnabled( int index, Boolean enabled );

        Boolean HS_IsNewFrame( int index );

        Pointer HS_GetVideoImage( int index );
    }
}
